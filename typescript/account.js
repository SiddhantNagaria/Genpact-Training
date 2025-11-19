var BankAccount = /** @class */ (function () {
    function BankAccount(holder, initialBalance) {
        if (initialBalance === void 0) { initialBalance = 0; }
        this.holder = holder;
        this.balance = initialBalance;
    }
    BankAccount.prototype.deposit = function (amount) {
        if (amount <= 0) {
            return "deposit amount should be positive";
        }
        this.balance += amount;
        return "Deposited ".concat(amount, ". New balance ").concat(this.balance);
    };
    BankAccount.prototype.withdraw = function (amount) {
        if (amount <= 0) {
            return "withdraw amount should be positive";
        }
        if (amount > this.balance) {
            return "insufficient balance";
        }
        this.balance -= amount;
        return "withdraw ".concat(amount, ". New balance: ").concat(this.balance);
    };
    BankAccount.prototype.getBalance = function () {
        return this.balance;
    };
    BankAccount.prototype.getHolder = function () {
        return this.holder;
    };
    return BankAccount;
}());
window.BankAccount = BankAccount;
