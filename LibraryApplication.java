import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}
class InvalidOperationException extends Exception{
    public InvalidOperationException(String msg){
        super(msg);
    }
}

class Library{
    private String bookTitle;
    private String author;
    private boolean isAvailable;

   

   // isAvailable=true;
    public void borrowBook() throws BookNotAvailableException{
        
        if(isAvailable){
        
        String[] arr={"Java programming"};
        System.out.println("Borrowing "+ arr[0]);
        System.out.println("Book borrowed successfully.");
        isAvailable=false;
       // System.out.println(isAvilable);


        }
        else{
            throw new BookNotAvailableException("Book is currently not available for borrowing.");
        }
       
        

    }
    public void returnBook() throws InvalidOperationException{
        if(!isAvailable){

       System.out.println("Book return successfully");
       isAvailable=true;
       
       }
       else{
         throw new InvalidOperationException("Invalid operation! Book is already available.");
       }
    }
    public void checkAvilability(){
        if(isAvailable){
            System.out.println("Book is avilable");
        }
        else{
            System.out.println("Book is not avilable");
        }
    }
    public void setIsAvailable(boolean isAvailable){

        this.isAvailable=isAvailable;

    }
    public boolean getIsAvailable(){
        return isAvailable;
    }

    
}

class LibraryApplication{
    
    public static void main(String[] args){
            System.out.println("Welcom to the library Managemnt System");

            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Check Book Availability");
            System.out.println("4. Exit");
            Library lib= new Library();
            lib.setIsAvailable(true);

         while(true){
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();

            

            

           // boolean result=lib.getIsAvilable();

            

            switch(choice){
                case 1:
                    try{
                        lib.borrowBook();
                    }
                    catch(BookNotAvailableException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:  
                   try{
                    lib.returnBook();
                   }
                   catch(InvalidOperationException e){
                    System.out.println(e.getMessage());
                   }
                    break;
                case 3:  
                    lib.checkAvilability();
                    break;

          }

        }
            
        
    }
}