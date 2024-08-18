Feature: Registering for to select products to cart
  I as a user want registering for to select products to cart

  Scenario Outline: Registering for to select products to cart successfully
    Given that the user open the registering page
    When I filling in the entire form with the following data '<email>' '<password>' '<gender>' '<address>' '<city>' '<state>' '<zip_code>' '<signature_waiver>'
    And I fill in the payment and billing details '<numberCard>' '<expiry_date>' '<security_code>' '<country>' '<full_name_billing>' '<address_line_billing>' '<city_billing>' '<state_billing>' '<zip_code_billing>'
    #Then Payment confirmation is successful

    Examples:
      | email                    | password     | gender | address | city  | state   | zip_code | signature_waiver | numberCard          | expiry_date | security_code | country  | full_name_billing   | address_line_billing | city_billing | state_billing | zip_code_billing |
      | erik.agudelo@wearedev.co | Sebastian18+ | Male   | Agudelo | miami | Florida | 33101    | waiver erik      | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Erik Manuel Agudelo | Calle 75             | Miami        | Florida       | 33101            |