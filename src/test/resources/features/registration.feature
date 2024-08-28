Feature: Registering for to select products to cart
  I as a user want registering for to select products to cart

  Scenario Outline: Registering for to select products to cart successfully
    Given that the user open the registering page
      | email   | password   |
      | <email> | <password> |
    When I filling in the entire form with the following data
      | phone_number   | gender   | address   | city   | state   | zip_code   | signature_waiver   |
      | <phone_number> | <gender> | <address> | <city> | <state> | <zip_code> | <signature_waiver> |
    And I fill in the payment and billing details
      | number_card   | expiry_date   | security_code   | country   | full_name_billing   | address_line_billing   | city_billing   | state_billing   | zip_code_billing   |
      | <number_card> | <expiry_date> | <security_code> | <country> | <full_name_billing> | <address_line_billing> | <city_billing> | <state_billing> | <zip_code_billing> |
    #Then Payment confirmation is successful

    Examples:
      | email                                            | password     | phone_number | gender | address | city  | state   | zip_code | signature_waiver | number_card         | expiry_date | security_code | country  | full_name_billing   | address_line_billing | city_billing | state_billing | zip_code_billing |
      #| erik.agudelo@wearedev.co | Sebastian18+ | 4564564567   | Male   | CL 75   | miami | Florida | 33101    | waiver erik      | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Erik Manuel Agudelo | Calle 75             | Miami        | Florida       | 33101            |
      | agudelo.0312@gmail.com                           | Sebastian18+ | 4564564567   | Male   | CL 75   | miami | Florida | 33101    | waiver erik      | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Erik Manuel Agudelo | Calle 75             | Miami        | Florida       | 33101            |
