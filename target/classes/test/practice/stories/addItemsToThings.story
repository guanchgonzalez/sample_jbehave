
Scenario: I have a Thing and I can add items to it

Given I have a Thing with an item named foo
When I add an item named bar
Then My Thing has 2 items
And My Thing has an item named bar
