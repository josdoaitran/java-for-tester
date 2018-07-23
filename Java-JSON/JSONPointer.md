# JSON Pointer

The entry API is the JsonPointer interface. An instance is created by calling the static factory method createPointer() on the Json class. The code snippet below creates a JsonPointer and references the second element in the likes array:
```
JsonPointer pointer = Json.createPointer("/likes/0");
```
The JsonPointer API can also mutate the JSON document by adding, replacing, and removing properties. The code snippet below adds the value “Java EE 8” to the likes list:
```
pointer.add(jsonObject, Json.createValue("Java EE 8"));
```
And the code in the following snippet replaces the value at the 3rd index position:
```
pointer = Json.createPointer("/likes/2");
JsonObject newJsonObject = pointer.replace(jsonObject, Json.createValue("Ice Cream"));
```
