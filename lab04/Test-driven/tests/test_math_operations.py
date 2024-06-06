# tests/test_math_operations.py
def test_addition():
    from src.math_operations import add
    assert add(1, 2) == 3

def test_subtraction():
    from src.math_operations import subtract
    assert subtract(5, 3) == 2