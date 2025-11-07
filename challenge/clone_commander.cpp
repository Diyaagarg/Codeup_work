#include <iostream>
#include <string>
using namespace std;

class Robot
{
public:
    string name;
    int battery;
    pair<int, int> position;

    // Constructor
    Robot(string n, int b, int x, int y)
    {
        name = n;
        battery = b;
        position = {x, y};
    }

    // Move robot
    void move(int dx, int dy)
    {
        position.first += dx;
        position.second += dy;
    }

    // Clone robot
    Robot *clone()
    {
        return new Robot(name + "_copy", battery, position.first, position.second);
    }

    // Display robot details
    void show(string label)
    {
        cout << label << ": " << name
             << " (Battery: " << battery
             << ", Position: (" << position.first << ", " << position.second << "))" << endl;
    }
};

int main()
{
    string command;
    Robot *original = nullptr;
    Robot *copy = nullptr;

    cout << "Enter commands (CREATE / MOVE / CLONE / SHOW / EXIT):" << endl;

    while (true)
    {
        cout << "\n> ";
        cin >> command;

        if (command == "CREATE")
        {
            string n;
            int b, x, y;
            cout << "Enter name, battery, x, y: ";
            cin >> n >> b >> x >> y;
            original = new Robot(n, b, x, y);
        }
        else if (command == "MOVE")
        {
            int dx, dy;
            cout << "Enter dx and dy: ";
            cin >> dx >> dy;
            if (original != nullptr)
            {
                original->move(dx, dy);
            }
            else
            {
                cout << "No robot created yet!" << endl;
            }
        }
        else if (command == "CLONE")
        {
            if (original != nullptr)
            {
                copy = original->clone();
                cout << "Clone created successfully!" << endl;
            }
            else
            {
                cout << "No robot to clone!" << endl;
            }
        }
        else if (command == "SHOW")
        {
            if (original != nullptr)
                original->show("Original");
            if (copy != nullptr)
                copy->show("Clone");
        }
        else if (command == "EXIT")
        {
            cout << "Exiting simulation..." << endl;
            break;
        }
        else
        {
            cout << "Invalid command! Try again." << endl;
        }
    }

    // Free memory
    delete original;
    delete copy;

    return 0;
}
