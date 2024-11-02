Feature : Purchase the order from e-com website
  it will buy an item from app.

  Background:
    Given : user landed on Ecommerce page
  Scenario Outline: Positive test of submitting the order

    Given : user enters with username <username> and password <password>
    When : user add product <productName> to cart
    And : check<productName> and submit the order
    Then : "THANKYOU FOR THE ORDER." message should be displayed on Confirmation Page

    Examples:
      | username                     | password       | productName  |
      | chauhanrohittt9936@gmail.com | Gopalsharma@99 |  IPHONE 13 |