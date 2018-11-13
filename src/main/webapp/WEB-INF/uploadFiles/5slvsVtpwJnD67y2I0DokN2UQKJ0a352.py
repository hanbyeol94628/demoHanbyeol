"""
print('\n\n')

print("태어난 년도를 입력하세요 : ", end="")
years = input()
print(int(years) >= 90)


print('\n\n')
print("파이썬 영어 철자를 입력하시오 : ", end="")
str = input()
print(str == 'python')

print('\n\n')
print('첫번째 수 입력 : ', end='')
num1 = input()
print('두번째 수 입력 : ', end='')
num2 = input()
print(int(num1) % int(num2) == 0)


print('\n\n')
print("12의 약수일까? : ", end="")
number = input()
print(12%int(number) == 0)
"""

print("\n\n")
print("정거장 수를 입력하세요 : ", end="")
stopP = int(input())
m = 2
if stopP > 10 :
    m = 4
time = int(stopP) * m
hour = time//60
minute = time%60
if hour != 0 :
    print("총 소요시간은 ", hour, "시간", minute,"분입니다.")
else :
    print("총 소요시간은 ", minute,"분입니다.")