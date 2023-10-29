import os

# Function to display the main menu
def display_menu():
    print("Task Manager Menu:")
    print("1. View tasks")
    print("2. Add task")
    print("3. Edit task")
    print("4. Delete task")
    print("5. Save and Exit")

# Function to view tasks
def view_tasks(tasks):
    print("\nCurrent Tasks:")
    for i, task in enumerate(tasks, 1):
        print(f"{i}. {task}")

# Function to add a task
def add_task(tasks):
    new_task = input("Enter the task: ")
    tasks.append(new_task)
    print("Task added!")

# Function to edit a task
def edit_task(tasks):
    view_tasks(tasks)
    task_num = int(input("Enter the task number to edit: ")) - 1
    if 0 <= task_num < len(tasks):
        new_task = input("Enter the new task: ")
        tasks[task_num] = new_task
        print("Task updated!")
    else:
        print("Invalid task number.")

# Function to delete a task
def delete_task(tasks):
    view_tasks(tasks)
    task_num = int(input("Enter the task number to delete: ")) - 1
    if 0 <= task_num < len(tasks):
        deleted_task = tasks.pop(task_num)
        print(f"Task '{deleted_task}' deleted.")
    else:
        print("Invalid task number.")

# Function to save tasks to a file
def save_tasks_to_file(tasks):
    with open("tasks.txt", "w") as file:
        for task in tasks:
            file.write(task + "\n")
    print("Tasks saved to 'tasks.txt'.")

# Function to load tasks from a file
def load_tasks_from_file():
    tasks = []
    if os.path.exists("tasks.txt"):
        with open("tasks.txt", "r") as file:
            for line in file:
                tasks.append(line.strip())
    return tasks

# Main function
def main():
    tasks = load_tasks_from_file()
    
    while True:
        display_menu()
        choice = input("Enter your choice: ")
        
        if choice == "1":
            view_tasks(tasks)
        elif choice == "2":
            add_task(tasks)
        elif choice == "3":
            edit_task(tasks)
        elif choice == "4":
            delete_task(tasks)
        elif choice == "5":
            save_tasks_to_file(tasks)
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()