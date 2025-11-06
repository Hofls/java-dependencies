### Info
* Provides context for LLMs (Lists everything about method parameters & return type)
* Test in sandboxed IDE:
    * `Gradle` -> `Tasks` -> `intelli` -> `runIde`
    * Open this project -> open `ManualTest` -> right click on method -> Extract context (for LLM)
* Build .zip:
  * `Gradle` -> `Tasks` -> `intelli` -> `buildPlugin`
  * Should appear [here](build/distributions)
* Install from .zip:
  * `Help` -> `Find action...` -> `Plugins` -> `Gear icon` -> `Install plugin from disk`

### Example
* Example input:
```
    public DataStructure.ResultDTO processUser(DataStructure.User user, DataStructure.Config config) {
        return new DataStructure.ResultDTO();
    }
```
* Example output:
```
Method: processUser

Parameters:
  User user
    - id: Long
    - name: String
    - address: Address
      - street: String
      - city: String
      - country: Country
        - name: String
        - code: String
    - orders: List<Order>
      - element: Order
        - orderId: String
        - items: List<Item>
          - element: Item
            - name: String
            - price: double
  Config config
    - timeout: int
    - debug: boolean
    - metadata: Map<String, String>
      - key: String
      - value: String

Return type:
  ResultDTO
    - success: boolean
    - message: String
    - summary: Summary
      - totalOrders: int
      - totalAmount: double
```