defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade/1" do
    @tag :percentage
    test "sample" do
      assert 85 ==
               Calculator.percentage_grade(%{
                 homework: [0.8],
                 labs: [1, 1, 1],
                 midterm: 0.70,
                 final: 0.9
               })
    end

    @tag :percentage
    test "with empty homework and non-empty labs" do
      input = %{homework: [], labs: [0.8, 0.7], midterm: 0.6, final: 0.7}
      assert Calculator.percentage_grade(input) == round((0.2 * 0.75 + 0.3 * 0 + 0.2 * 0.6 + 0.3 * 0.7) * 100)
    end

    @tag :percentage
    test "with all zeros" do
      input = %{homework: [0, 0], labs: [0, 0], midterm: 0, final: 0}
      assert Calculator.percentage_grade(input) == 0
    end

    @tag :percentage
    test "with varied values" do
      input = %{homework: [0.5, 0.6], labs: [0.9, 0.8], midterm: 0.75, final: 0.85}
      assert Calculator.percentage_grade(input) == round((0.2 * 0.85 + 0.3 * 0.55 + 0.2 * 0.75 + 0.3 * 0.85) * 100)
    end
  end

  describe "letter_grade/1" do
    @tag :letter
    test "resulting in A+" do
      input = %{homework: [0.9, 0.9], labs: [0.9, 0.9], midterm: 0.9, final: 0.9}
      assert Calculator.letter_grade(input) == "A+"
    end

    @tag :letter
    test "resulting in EIN due to low homework" do
      input = %{homework: [0.3, 0.3], labs: [0.9, 0.9], midterm: 0.9, final: 0.9}
      assert Calculator.letter_grade(input) == "EIN"
    end

    @tag :letter
    test "resulting in EIN due to low exams" do
      input = %{homework: [0.9, 0.9], labs: [0.9, 0.9], midterm: 0.3, final: 0.3}
      assert Calculator.letter_grade(input) == "EIN"
    end

    @tag :letter
    test "resulting in B due to borderline scores" do
      input = %{homework: [0.7, 0.7], labs: [0.7, 0.7], midterm: 0.7, final: 0.7}
      assert Calculator.letter_grade(input) == "B"
    end
  end

  describe "numeric_grade/1" do
    @tag :numeric
    test "resulting in 10" do
      input = %{homework: [0.9, 0.9], labs: [0.9, 0.9], midterm: 0.9, final: 0.9}
      assert Calculator.numeric_grade(input) == 10
    end

    @tag :numeric
    test "resulting in 0 due to low homework" do
      input = %{homework: [0.3, 0.3], labs: [0.9, 0.9], midterm: 0.9, final: 0.9}
      assert Calculator.numeric_grade(input) == 0
    end

    @tag :numeric
    test "resulting in 0 due to low exams" do
      input = %{homework: [0.9, 0.9], labs: [0.9, 0.9], midterm: 0.3, final: 0.3}
      assert Calculator.numeric_grade(input) == 0
    end

    @tag :numeric
    test "resulting in 6 due to borderline scores" do
      input = %{homework: [0.7, 0.7], labs: [0.7, 0.7], midterm: 0.7, final: 0.7}
      assert Calculator.numeric_grade(input) == 6
    end

    # Additional tests to achieve 100% branch coverage
    @tag :numeric
    test "resulting in 0 with too few labs" do
      input = %{homework: [0.9, 0.9], labs: [0.1], midterm: 0.9, final: 0.9}
      assert Calculator.numeric_grade(input) == 0
    end

    @tag :numeric
    test "resulting in 0 with too low average" do
      input = %{homework: [0.5, 0.6], labs: [0.9, 0.8], midterm: 0.55, final: 0.65}
      assert Calculator.numeric_grade(input) == 0
    end
  end
end
