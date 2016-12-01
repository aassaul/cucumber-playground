Feature: Post articles

  Scenario Outline: Post article by owner

    Given I signed up as owner
    When I write article <article name>
    And text of article is <article text>
    And I post article
    Then I should see "Article is created"
    And Created article name is <article name>
    And Created article text is <article text>
    Examples:
      | article name              | article text |
      | "About my last nigh trip" | "text"       |
      | "New article"             | "new text"   |
      | "New article 2"           | ""           |

  Scenario: Post article by user

    Given I signed up as user
    When I write article "About my last nigh trip"
    And text of article is "..no more"
    And I post article
    Then I should see "You have no access to post articles"