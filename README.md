# jaxb-project
Full working JAXB project with marshal/unmarshal methods.

Tools used:
- Java 8 EE
- JAXB 2.2

Be sure to fit project classes/methods to match your Java objects/.xml files.

Engine class:
- marshals single Java objects, creating a new .xml file for each one.
- unmarshals .xml single files with single object on them.

EngineArrayList class is for multiple objects use.
- marshals multiple Java objects, added in an ArrayList<> first. Single file for each ArrayList<>.
- unmarshals .xml single files with an ArrayList<> of objects on them.

To unmarshal in Engine/EngineArrayList:
- Copy .xml file in project root directory, then copy .xml filename and paste it in "new File" parameter.

