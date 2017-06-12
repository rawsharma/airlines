**Create Airplane**
----
  Create an airplane

* **URL**

  /rs/airplane/

* **Method:**

  `POST`
  
*  **URL Params**

   None

* **Data Params**

  **Required:** `capacity=[integer]`
  
  **Required:** `model=[string]`
  
  **Required:** `serialnr=[string]`

* **Success Response:**

  * **Code:** 200
  
    **Content:** 
    ```
    {
        "capacity": 50,
        "id": 8,
        "model": "745",
        "serialnr": "54333"
    }
    ```
 
* **Error Response:**

  * **Code:** 500 Server Error
  


  ```