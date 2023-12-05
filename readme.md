1. ������������� �������������� ���������:
   **interface ByCondition {boolean isOk(int number);}**
   � �������������� ���������� ����������� ���������� ���������.
2. ������� ����� Sequence ��� ������������������ �� ��������� �������:
   **public static int[] filter(int[] array, ByCondition condition) {...}**
   ������ ����� ���������� ������, ������� �������� ��������, ��������������� ����������� ��������� � condition.
3. � main � �������� condition ����������:

- �������� �� �������� ��������
- ��������, �������� �� ����� ���� �������� ������ ������.

4. ��������� ����������� � ��������� �����
   git _homeworks/homework010_.
   ��� ���������� ��������� ��������� (�������) ������� ��������� � ��������� ���� ������
   �� ������. � ����� ����� � ���������� ������ ���� ���� _.gitignore_.

---

1. ������� ��������� Optional.
2. ���������� generic-����� Pair, ������� �� Optional, �� ���������� ���� ��������� ������
   ����� � �� ����������� ��������� ��������� �������� null.
3. ���������� ������ getFirst(), getSecond(), equals() � hashCode(), � ����� ����������� ��������� �����
   of(). ����������� ������ ���� ��������(private).
4. � ��������� ������������� ������� Pair ������ ��������������� � ������� �������� ��������� ���:

`Pair<Integer, String> pair = Pair.of(1, "hello");`

`Integer i = pair.getFirst(); // 1`

`String s = pair.getSecond(); // "hello"`

`Pair<Integer, String> pair2 = Pair.of(1, "hello");`

`boolean mustBeTrue = pair.equals(pair2); // true!`

`boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!`