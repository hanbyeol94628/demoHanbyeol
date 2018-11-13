"""
print('\n\n')
print("숫자를 입력하세요 : ", end="")
num = int(input())
if num > 0 :
    print(num,"을 입력하였습니다.")
else :
    print("음수이며 ", num, "을 입력하였습니다.")


print("\n\n")
print("태어난 년도를 2자리로 입력하십시오 : ", end="")
year = int(input())
if(year < 10) :
    year += 2000
else :
    year += 1900
age = 2018 - year
print(year,"년도에 태어난 당신은 ",age,"살입니다.")



print("\n\n")
print("태어난 년도를 입력하시오: ", end="")
year = int(input())
if(year < 19) :
    year += 2000
elif(year < 100 and year > 19) :
    year += 1900
age = 2018 - year + 1
print(year,"년에 태어난 당신은 ", age,"살입니다.")


print("\n\n")
print("숫자를 입력해주세요 : ",end="")
num = int(input())
number = -num
print("절대값 : " , number)



print("\n\n")
print("사용자의 거리를 입력하세요 : " , end="")
dis = int(input())
m = 50-dis
if(dis == 50) :
    print("최대유효사거리와 정확히 일치합니다.")
elif(dis < 50) :
    print("최대유효사거리보다", m, "m 가깝습니다.")
elif(dis > 50) :
    print("최대유효사거리보다", -m, "m 멉니다.")


print("\n\n")
A = 5
B = 7
print("현재 층 수 : ", end="")
now = int(input())
if(now >= 7) :
    print("B 엘리베이터가 동작합니다.")
elif(now <= 5) :
    print("A 엘리베이터가 동작합니다.")
else :
    print("A, B 엘리베이터 둘 다 동작합니다.")



print("\n\n")
print("점수를 입력하세요 : ", end="")
n1 = int(input())
print("점수를 입력하세요 : ", end="")
n2 = int(input())
print("점수를 입력하세요 : ", end="")
n3 = int(input())
print("점수를 입력하세요 : ", end="")
n4 = int(input())
print("점수를 입력하세요 : ", end="")
n5 = int(input())


print('\n\n')
str = input('문자 입력 :')
for i in range(0,5):
    print(i+1,".",str)


print("\n\n")
num = int(input('숫자 입력 : '))
result = 0
for i in range(0, num) :
   result += i+1  
print('1~',num,' 합 : ',result)


print("\n\n")
num = int(input('숫자 입력 :'))
for i in range (0, num+1) :
    print(num - i)


print("\n\n")
num = int(input('30이하의 수 입력: '))
if num <= 30 :
    sum = 0
    for i in range (num, 31) :
        if i%3 == 0 :
            sum += i
    print('sum = {0}'.format(sum))
else :
    print('30이하 ㅡㅡ')


