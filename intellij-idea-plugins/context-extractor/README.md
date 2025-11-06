* Provides context for LLMs (Lists everything about method parameters & return type)
* Test in sandboxed IDE:
    * `Gradle` -> `Tasks` -> `intelli` -> `runIde`
    * Open this project -> open `ManualTest` -> right click on method -> Extract context (for LLM)
* Build .zip:
  * `Gradle` -> `Tasks` -> `intelli` -> `buildPlugin`
  * Should appear [here](build/distributions)
* Install from .zip:
  * `Help` -> `Find action...` -> `Plugins` -> `Gear icon` -> `Install plugin from disk`
