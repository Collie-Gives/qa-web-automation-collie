Feature: Pricing To Choose a plan
  I as a user want to choose a plan
  For strategic planning and business intelligence software

  Scenario Outline: Choose a plan successfully
    Given that the user open the pricing page
    #When I select the <period> and subscribe to the <plan>
    #And I fill out basic information '<First_Name>' '<Last_Name>' '<Email_Address>' '<Phone_Number>'
    #And I fill out company information '<Company_Name>' '<Fiscal_Year>' '<Accounting_Software>' '<Country>' '<State>' '<City>' '<Currency>'
    #And I fill out payment method '<Company_Name>' '<Fiscal_Year>' '<Accounting_Software>' '<Country>' '<State>' '<City>' '<Currency>'
    #Then Payment confirmation is successful

    Examples:
      | period   | plan     | First_Name | Last_Name | Email_Address            | Phone_Number | Company_Name     | Fiscal_Year | Accounting_Software | Country       | State   | City         | Currency |
      | Monthly  | Basic    | Erik       | Agudelo   | agudelo.0312+3@gmail.com | 1707844025   | Company Test     | April       | Acumatica           | United States | Florida | Miami        | USD      |