Feature: Create campaign in colliegives.com application

  @smoke
  Scenario Outline: Create a successful draft campaign
    Given that login with the following credentials '<user>'
    When create a new campaign with the following data
      | city   | state   | star_date   | end_date   | fundraising   | attendees   | teams   |
      | <city> | <state> | <star_date> | <end_date> | <fundraising> | <attendees> | <teams> |
    Then verify that the campaign has been created successfully

    Examples:
      | user      | city  | state   | star_date  | end_date   | fundraising | attendees | teams |
      | USER_ERIK | Miami | Florida | 09/10/2024 | 09/20/2024 | 100         | 20        | 5     |

  @regression
  Scenario Outline: Create a successful campaign by adding an experience
    Given that login with the following credentials '<user>'
    When create a new campaign with the following data
      | city   | state   | star_date   | end_date   | fundraising   | attendees   | teams   |
      | <city> | <state> | <star_date> | <end_date> | <fundraising> | <attendees> | <teams> |
    Then verify that the campaign has been created successfully
    * And add to the campaign the experience '<experienceName>' '<experienceCategory>'
    * And add to the experience images
    * And add to the experience general settings
    * And add to the experience registration options with the following data
      | registrationName    | description                   | attendeeCap | minimumFundraising | nameProduct      |
      | Test Registration 1 | Test Registration Champion    | 100         | 200                | Champion T-shirt |
      | Test Registration 2 | Test Registration SubChampion | 200         | 300                | Champion T-shirt |
    #* And add to the experience early bird registration '<UrlCode>'
    #* And add to the experience waiver '<WaiverDescription>'
    #* And add to the experience donation settings
    #* And add to the experience donation options
    #* And add to the experience fundraising settings
    #* And add to the experience store the product '<nameProduct>'
    #* And add to the experience individual fundraising
    #* And add to the experience team settings "5" maximun team and "6" maximun team members
    #* And add to the experience bib assignment
    #* And add the our story the title '<OurStoryTitle>' and description '<OurStoryDescription>' in experience landing page
    #* And now the campaign is displayed live

    Examples:
      | user      | city  | state   | star_date  | end_date   | fundraising | attendees | teams | experienceName | experienceCategory | registrationName  | description               | attendeeCap | nameProduct      | UrlCode | WaiverDescription                                      | OurStoryTitle | OurStoryDescription            |
      | USER_ERIK | Miami | Florida | 09/10/2024 | 09/20/2024 | 100         | 20        | 5     | Race for life  | Run/Walk           | Test Registration | Test Registration Options | 100         | Champion T-shirt | EARLY   | We are not responsible for anything the happens to you | Our Mission   | We need money to help our kids |