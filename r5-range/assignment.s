
# This assignment asks you to find the range of a data array.

# Namely, you must find the range of the data array that starts
# at memory address $0 and contains $1 words.
# The range is the maximum value minus the minimum value in the data.
# All values should be viewed as unsigned.
# The range must be stored in register $2.
# Complete and submit the part delimited by "----" and indicated by
# a "nop" below.

# Here is some wrapper code to test your solution:

        mov     $0, >test_data  # set up the address where to get the data
        mov     $1, >test_len   # set up address where to get the length
        loa     $1, $1          # load the length from memory to $1

# Your solution starts here ...
# ------------------------------------------

      	cmp $1, 0   		#Compare test len and 0
  		bab >part1			#If left > right (unsigned) continue from part @part1.
		hlt					#Else halt the execution.
  
  @part1:

  		mov $5, $0 			#$5 = test data.
  		add $6, $5, $1    	#$6 = testdata + test len
  		loa $3, $5    		#$3 = [load test data]
  		loa $4, $5    		#$4 = [load test data]
  		add $5, $5, 1    	#test data += 1
  		cmp $6, $5			#Compare $6 and $5
  		bab >part2			#If left > right continue from @part2
  		jmp >part3			#Else continue from @part 3
  		
  @MAX:						
  		mov $3, $7			#Every time we come to this part we save the new max value at $3.
  		add $5, $5, 1    	#And increment 5 by 1.
  		cmp $6, $5			#And do the same comparisons to know where to continue the loop.
  		bab >part2
  		jmp >part3

  @MIN:						
  		mov $4, $7			#Every time we come to this part we save the new max value at $4.
  		add $5, $5, 1    	#And increment 5 by 1.
  		cmp $6, $5			#And do the same comparisons to know where to continue the loop.
  		bab >part2
  		jmp >part3		
  		
  		
  @part2:					#In this part we check if max on min value need to be modified one bit at a time.
  
  		loa $7, $5    		#$7 = $5
  		cmp $3, $7			#Compare $3 and $7.
  		bbe >MAX  			#If left <= right, continue from @MAX
  		cmp $4, $7			#Compare $4 and $7.
  		bae >MIN  			#If left >= right, continue from @MAX
  		add $5, $5, 1    	#$5 += 1.
  		cmp $6, $5			#If $6 > $5...
  		bab >part2			#... continue from part2.

  @part3:
  		sub $2, $3, $4		#When everything is processed, take diff max - min => range.
        hlt
# ------------------------------------------
# ... and ends here 

        hlt                     # the processor stops here

# Here is some test data:
# (the minimum is 151 and the maximum is 9978, so the range is 9978-151 = 9827)

@test_len:
        %data   35
@test_data:
        %data   6277, 1692, 8747, 5105, 6424, 6431, 1311, 4497, 1112, 806, 7346, 5891, 6225, 295, 8615, 2294, 5190, 151, 4255, 6114, 9978, 3836, 7304, 1808, 5982, 3809, 7795, 1222, 6552, 4946, 7264, 7249, 8476, 2887, 9384


