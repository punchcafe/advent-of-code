res = File.stream!("./priv/day_one/input_1.txt")
|> Stream.map(&Integer.parse/1)
|> Stream.map(&elem(&1, 0))
|> Enum.to_list()
|> Sonar.count_increases()

IO.inspect(res)
