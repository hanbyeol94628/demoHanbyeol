"""
print('\n\n')
while True :
    num = int(input('수를 입력하세요 : '))
    if num <= 10 : break


print('\n\n')
while True :
    num = input('수를 입력하세요 : ')
    if num == "Q" :
        break
    elif int(num)%3 == 0 :
        print("{0}는 3의 배수!".format(num))
    else :
        print("{0}는 3의 배수가 아님!".format(num))


print('\n\n')
sum = 0
cnt = 0
while True :
    num = int(input('수를 입력하세요 : '))
    sum += num
    cnt += 1
    print("입력된 수 : {0}, 총합 : {1}".format(cnt, sum))
    if num >= 10 : break
print('\n\n')

"""
print('\n\n')
print("수를 입력하세요 : ", end="")
int
    