## 세  수를 입력받아 합계와 평균을 구하시오 (소수점 2자리)
#num1 = input()
#num2 = input()
#num3 = input()
#sum = int(num1) + int(num2) + int(num3)
#avg = ("{0:0.2f}".format(sum/3))
#print("입력 받은 값 : ", num1, ", ", num2, ", ", num3)
#print("합 = ", sum, " 평균 : ", avg)

#print('\n\n')
## 삼각형 나머지 각 구하기
#a1 = input()
#a2 = input()
#a3 = 180 - int(a1) - int(a2)
#print("입력 : ", a1, a2)
#print("나머지 값은 ", a3, "도 이다.")

print('\n\n')
print("정거장 수를 입력하시오 : ", end="")
stoppoint = input()
time = int(stoppoint) * 3 

hour = time//60
minute = time%60
print("총 소요 시간은 ", hour, "시간 ", minute, "분입니다.")