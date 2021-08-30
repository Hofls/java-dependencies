* There is a problem in swagger.
* If different classes, from different namespaces have the same name - swagger client generates just one class, and completely ignores another.
* To fix it - prvoide alternative name for one of the classes via `@ApiModel`
