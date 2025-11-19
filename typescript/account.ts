class BankAccount {
  private holder: string;

  private balance: number;

  constructor (holder: string, initialBalance: number = 0) {
    this.holder = holder
    this.balance = initialBalance
  }
  deposit(amount:number): string{
    if(amount<=0){
        return `deposit amount should be positive`;
    }
    this.balance+=amount;
    return `Deposited ${amount}. New balance ${this.balance}`;
  }

  withdraw(amount:number):string{
      if(amount<=0){
        return `withdraw amount should be positive`;
    }
    if(amount>this.balance){
        return `insufficient balance`;
    }
    this.balance-=amount;
    return `withdraw ${amount}. New balance: ${this.balance}`;
  }
  getBalance():number{
    return this.balance;
  }
  getHolder():string{
    return this.holder;
  }
}

(window as any).BankAccount= BankAccount;