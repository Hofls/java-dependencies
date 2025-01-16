### Ideas
* Generate code straight to the `target` folder
  * No need for anything fancy - just scan folder for text files, read them, then use StringBuilder and save result to a new file
  * Example - in facade/bff, for each @FeignClient, generate @RestController

### Refactoring
* Find 100 biggest classes (to break them up): \
  `find . -type f -exec du -h {} + | sort -rh | head -n 100`
