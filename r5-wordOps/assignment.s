
# This assignment asks you to implement some basic word operations
# with assembly language.

# Namely, your solution should implement all of the following:
# 1) Reverse the order of bits in $0 and store the result in $5
#    (that is, the bit in position 0 goes to position 15, position 1 goes
#    to position 14, position 2 goes to position 13, ..., and position 15
#    goes to position 0; the contents of $0 must remain unchanged);
# 2) Count the number of 1-bits in $0 and store the result in $6; and
# 3) Rotate the bits in $0 by one position to the left and store 
#    the result in $7. (That is, bit in position 0 goes to position 1, 
#    position 1 goes to 2, position 2 goes to 3, ..., position 14 goes 
#    to position 15, and position 15 goes to position 0.)

# Here is some wrapper code to test your solution:
        
        mov     $0, 62361       # load test input to $0
                
# Your solution starts here ...
# ------------------------------------------
        
       	mov $5, 0		# $5 = 0. (Soon to be reversed binary string)
  		mov $3, 15		# $3 = 15. (initializing counter)
  		
@loop1: cmp $3, -1  	# Comparing if $3 == -1. (when all bits are handled)
 		beq >done1		# Iff true move to @done1.
 		lsl $5, $5, 1 	# $5 = $5 shifted to the left by 1 bits.
  		lsl $1, $0, $3	# $1 = $0 shifted to the left by $3 bits.
 		lsr $2, $1, 15	# $2 = $1 shifted to the right by 15 bits.
  		sub $3, $3, 1	# $3 -= 1 
  		add $5, $5, $2	# $5 += $2 -> building the reversed binary string one-by-one.
  		jmp >loop1		# Execute loop again.

@done1: mov $6, 0		# $6 = 0. (Soon to be 1-bit count)
  		mov $3, 15		# $3 = 15. (initializing counter)

@loop2: cmp $3, -1		# Comparing if $3 == -1. (when all bits are handled)
  		beq >done2		# Iff true move to @done2.
  		lsl $1, $0, $3	# $1 = $0 shifted to the left by $3 bits.
	  	lsr $2, $1, 15	# $2 = $1 shifted to the right by 15 bits.
	  	and $4, $2, 1	# $4 = bitwise AND of $2 and 1
	  	sub $3, $3, 1	# $3 -= 1
	  	add $6, $6, $4	# $6 += $4 -> counting 1-bits one-by-one.
	  	jmp >loop2		# Execute loop again.
  

@done2: lsr $3, $0, 15	# When we have the asked $5 and $6...
  		lsl $7, $0, 1	# ...$7 = $0 left sifted by 1 bit.
  		add $7, $7, $3	# $7 += $3, ($3 = -1)

# ------------------------------------------
# ... and ends here 

        hlt                     # the processor stops here

# (at halt we should have 39375 in $5, 10 in $6, and 59187 in $7)


