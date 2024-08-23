public class Manipulacao {
    public String convertTextFileToString(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {

            return stream.collect(Collectors.joining(" "));
        } catch (IOException | URISyntaxException e) {
            return null;
        }
    }

    
}
