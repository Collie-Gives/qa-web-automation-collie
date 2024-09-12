Feature: Registering for to select products to cart
  I as a user want registering for to select products to cart

  @smoke_registration
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
      | email                  | password     | phone_number | gender | address | city  | state   | zip_code | signature_waiver | number_card         | expiry_date | security_code | country  | full_name_billing   | address_line_billing | city_billing | state_billing | zip_code_billing |
      #| erik.agudelo@wearedev.co | Sebastian18+ | 4564564567   | Male   | CL 75   | miami | Florida | 33101    | waiver erik      | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Erik Manuel Agudelo | Calle 75             | Miami        | Florida       | 33101            |
      | agudelo.0312@gmail.com | Sebastian18+ | 4564564567   | Male   | CL 75   | miami | Florida | 33101    | waiver erik      | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Erik Manuel Agudelo | Calle 75             | Miami        | Florida       | 33101            |


  @regression_registration
  Scenario Outline: Registration and ticketing selecting a campaign
    Given that login with the following credentials '<userLogin>'
    * selecting the campaign '<select_campaign_name>' and experience '<select_experience_name>' for registration and ticketing
    * that the user open the registering page
      | userRegistration   | passwordRegistration   |
      | <userRegistration> | <passwordRegistration> |
    When I fill in the whole form with the following data, selecting items from the first option
      | minor   | name_minor   | phone_number   | gender   | address   | city   | state   | zip_code   | signature_waiver   |
      | <minor> | <name_minor> | <phone_number> | <gender> | <address> | <city> | <state> | <zip_code> | <signature_waiver> |
    #* now choose how you want to participate: 'Create a team' with: 'Team Name Test' and '100'
    #* now choose how you want to participate: 'Join a team' with: 'Team Name Test'  //FALTA INSUMOPARA SELECCIONAR EL EQUIPO
    * now choose how you want to participate: 'Continue without a team'
    * now swag bag selection
    * would you like to buy something?
    * would you like to make a donation
    And I fill in the payment and billing details
      | number_card   | expiry_date   | security_code   | country   | full_name_billing   | address_line_billing   | city_billing   | state_billing   | zip_code_billing   |
      | <number_card> | <expiry_date> | <security_code> | <country> | <full_name_billing> | <address_line_billing> | <city_billing> | <state_billing> | <zip_code_billing> |
    #Then Payment confirmation is successful

    Examples:
      | userLogin | userRegistration      | passwordRegistration | select_campaign_name | select_experience_name | minor | name_minor | phone_number | gender | address     | city   | state | zip_code | signature_waiver   | number_card         | expiry_date | security_code | country  | full_name_billing | address_line_billing | city_billing | state_billing | zip_code_billing |
      | USER_ERIK | kimdawn0614@gmail.com | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 | 1     | Jacob Cook | 4564564567   | Female | 123 Main St | Austin | Texas | 78731    | waiver kimdawn0614 | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
