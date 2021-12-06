defmodule Sonar do


  def count_increases([first | values]), do: do_count_increases(first, values, 0)
  defp do_count_increases(_current, [], count), do: count
  defp do_count_increases(current, [next| rest], count) when current < next, do: do_count_increases(next, rest, count + 1)
  defp do_count_increases(current, [next| rest], count) when current >= next, do: do_count_increases(next, rest, count)
end
