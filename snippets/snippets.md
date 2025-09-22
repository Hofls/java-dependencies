* Some snippets are located in other packages:
    * `hibernate`
    * `lombok`
    * `redis`
    * `mapstruct`
    * `message-queue`
    * etc
* Do dates overlap?
  ```
  public static boolean doPeriodsOverlap(LocalDateTime start1, LocalDateTime end1,
                                         LocalDateTime start2, LocalDateTime end2) {
      return !start1.isAfter(end2) && !end1.isBefore(start2);
  }
  ```
* 