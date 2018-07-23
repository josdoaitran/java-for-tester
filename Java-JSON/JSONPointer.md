# JSON Pointer

The entry API is the JsonPointer interface. An instance is created by calling the static factory method createPointer() on the Json class. The code snippet below creates a JsonPointer and references the second element in the likes array:
```
JsonPointer pointer = Json.createPointer("/likes/0");
```
