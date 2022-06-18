# Here is some wrapper code to test your solution:

        mov     $0, 3908        # load some values to registers $0,$1,$2,$3,$4
        mov     $1, 762
        mov     $2, 5340
        mov     $3, 1623
        mov     $4, 4042
                
# Your solution starts here ...
# ------------------------------------------
	
sub $3, $3, $4 # First we execute calculations that are between brackets.
add $0, $0, $1 # When there are no brackets we execute from left to right...
add $0, $0, $2 # ...one operation at a time...
sub $0, $0, $3 # ...until...
mov $7, $0 # ...we save the solution to register 7.
    
# ------------------------------------------
# ... and ends here 

	hlt     	        # the processor stops here

# (at halt we should have 12429 in $7)