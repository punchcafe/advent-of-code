package dev.punchcafe.aoc.d04;

import static java.util.stream.Collectors.toMap;

import java.io.BufferedReader;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

public class PassportConverter {

    public static Stream<Passport> convertData(final BufferedReader reader) throws IOException {
        return parseEntries(reader)
                .stream()
                .map(PassportConverter::parseSingleEntry)
                .map(PassportConverter::parseEntry);
    }

    private static List<String> parseEntries(final BufferedReader lines) throws IOException {
        final var result = new ArrayList<String>();
        String line = lines.readLine();
        StringBuilder entryBuilder = new StringBuilder();

        while(line != null){
            if(line.trim().equals("")){
                result.add(entryBuilder.toString());
                entryBuilder = new StringBuilder();
                line = lines.readLine();
                continue;
            }
            entryBuilder.append(line).append(" ");
            line = lines.readLine();
        }
        return result;
    }

    private static Map<String, String> parseSingleEntry(final String entry){
        return Optional.of(entry)
                .map(ent -> ent.replaceAll("\\n", " "))
                .map(ent -> ent.replaceAll(" +", " "))
                .stream()
                .flatMap(ent -> Arrays.stream(ent.split(" ")))
                .map(ent -> Map.entry(ent.split(":")[0], ent.split(":")[1]))
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    private static Passport parseEntry(final Map<String, String> passportEntry) {
        final var setterMap = Arrays.stream(Passport.class.getDeclaredFields())
                .collect(toMap(field ->
                                       field.getAnnotation(DataCode.class).value(),
                               field -> {
                                   try {
                                       final var methodName = "set" + capitalise(field.getName());
                                       return Passport.class.getMethod(methodName, String.class);
                                   } catch (NoSuchMethodException ex) {
                                       throw new RuntimeException();
                                   }
                               }));

        final var passport = new Passport();
        passportEntry.entrySet()
                .forEach(entry -> {
                    final var setter = setterMap.get(entry.getKey());
                    try {
                        setter.invoke(passport, entry.getKey());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
        return passport;
    }

    private static String capitalise(String string) {
        final StringBuilder sb = new StringBuilder();
        sb.append(string.substring(0, 1).toUpperCase().charAt(0));
        sb.append(string.substring(1));
        return sb.toString();
    }
}
