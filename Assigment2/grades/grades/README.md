# Grades

To start your Phoenix server:

  * Install dependencies with `mix deps.get`
  * Install Node.js dependencies with `npm install` inside the `assets` directory
  * Start Phoenix endpoint with `mix phx.server`

Now you can visit [`localhost:4000`](http://localhost:4000) from your browser.

Ready to run in production? Please [check our deployment guides](https://hexdocs.pm/phoenix/deployment.html).

## Learn more

  * Official website: https://www.phoenixframework.org/
  * Guides: https://hexdocs.pm/phoenix/overview.html
  * Docs: https://hexdocs.pm/phoenix
  * Forum: https://elixirforum.com/c/phoenix-forum
  * Source: https://github.com/phoenixframework/phoenix

Summary of Refactorings

Extract avg/1 Helper Method: To handle the calculation of averages and remove duplicate code.
Extract failed_to_participate?/3 Helper Method: To encapsulate the logic for checking if a student failed to participate adequately.
Extract calculate_grade/4 Helper Method: To encapsulate the grade calculation formula.
Extract grade_to_letter/1 Helper Method: To encapsulate the logic for converting a numerical grade to a letter grade.
Extract grade_to_numeric/1 Helper Method: To encapsulate the logic for converting a numerical grade to a numeric grade.
