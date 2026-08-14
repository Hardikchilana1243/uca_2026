function* calc(initialValue) {
    let result = initialValue;

    if (typeof result !== "number" || !Number.isFinite(result)) {
        yield "Invalid input";
        return;
    }

    while (true) {
        const input = yield result;

        if (
            !input ||
            typeof input !== "object" ||
            !["add", "subtract", "multiply", "divide"].includes(input.operation) ||
            typeof input.value !== "number" ||
            !Number.isFinite(input.value)
        ) {
            yield "Invalid input";
            continue;
        }

        const { operation, value } = input;

        switch (operation) {
            case "add":
                result += value;
                break;

            case "subtract":
                result -= value;
                break;

            case "multiply":
                result *= value;
                break;

            case "divide":
                if (value === 0) {
                    yield "Error: Cannot divide by zero";
                    continue;
                }
                result /= value;
                break;
        }

        yield result;
    }
}


const calculator = calc(50);

console.log(calculator.next().value); 

console.log(calculator.next({
    operation: "add",
    value: 30
}).value);

console.log(calculator.next({
    operation: "multiply",
    value: 2
}).value);

console.log(calculator.next({
    operation: "add",
    value: "30"
}).value);

console.log(calculator.next({
    operation: "multiply",
    value: 0
}).value);