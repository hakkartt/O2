
# This assignment asks you to write an assembly-language program that
# multiplies two integers.
        
# Namely, your task is to compute $0 * $1 and store the result in $2.
# The result is guaranteed to be in the range 0,1,...,65535.
# Both $0 and $1 should be viewed as unsigned integers.
# Complete and submit the part delimited by "----" and indicated by
# a "nop" below.

# Here is some wrapper code to test your solution:

        mov     $0, 82          # load some values to registers $0,$1
        mov     $1, 430

# Your solution starts here ...
# ------------------------------------------
        #Initializing some values.
        mov $2, 0        		#$2 = 0.	Here we save the result, starting from 0 ofc.
        mov $3, 1				#43 = 1.	Carry.
        mov $4, 0				#$4 = 0.	
        mov $5, 15				#$5 = 15. 	(last index of an integer (16-bit word))
        mov $6, 0				#$6 = 0.	Minimum of possible results.
        mov $7, 65535			#$7 = 65535. Maximum of possible results.
        
@part1:
        cmp $1, 0
        beq >part3				#If $1 == 0 continue from part3.
        and $4, $3, $1			#$4 = bitwise AND of $3 and $1.
        cmp $4, 0				
        beq >part2				#If $4 == 0 continue from part2.
        and $4, $7, $0			#$4 = bitwise AND of $7 and $0.
        lsl $4, $4, $6			#$4 = $4 left sifted by $6-value amount of bits.
        add $2, $2, $4			#$2 += $4
        	
@part2:
        add $6, $6, 1			#$6 += 1
        lsr $1, $1, 1			#$1 = $1 right sifted by 1 bits.
        jmp >part1				#Continue from part1.
        
@part3:
		hlt
# ------------------------------------------
# ... and ends here 

        hlt                     # the processor stops here

# (at halt we should have 35260 in $2)


