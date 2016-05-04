Cloud Vision Test
======

Simple aplicación que solo sirve para probar la habilidad de Google Cloud Test Vision de detectar el contenido de una imagen.

Uso
------------
```
./gradlew run -Dargs="-file imagen.png -maxResults 10 -apiKey=THE_KEY"
```

* -file : Archivo al cual Cloud Vision realizara la operación.
* -maxResults : Numero máximo de resultados esperados.
* -apiKey : Google Cloud API KEY. (El Api Key también puede estar en una variable del sistema llamada VISION_API_KEY)

Nota
------------
Esta aplicación no tiene ni tendrá ningún unit test. Solo fue creada para un challange.



License
--------

    Copyright 2016 Carlos Paulino

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.