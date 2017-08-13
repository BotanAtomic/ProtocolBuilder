package com.ankamagames.dofus.network.messages.authorized;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ConsoleCommandsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6127;
    private boolean _isInitialized = false;
    private String[] aliases;
    private String[] args;
    private String[] descriptions;
    private FuncTree _aliasestree;
    private FuncTree _argstree;
    private FuncTree _descriptionstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.aliases.length);
         int _loc2_ = 0;
         while(_loc2_ < this.aliases.length)
         {
            param1.writeUTF(this.aliases[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.args.length);
         int _loc3_ = 0;
         while(_loc3_ < this.args.length)
         {
            param1.writeUTF(this.args[_loc3_]);
            _loc3_++;
         }
         param1.writeShort(this.descriptions.length);
         int _loc4_ = 0;
         while(_loc4_ < this.descriptions.length)
         {
            param1.writeUTF(this.descriptions[_loc4_]);
            _loc4_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         String _loc8_ = null;
         String _loc9_ = null;
         String _loc10_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc8_ = param1.readUTF();
            this.aliases.push(_loc8_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc9_ = param1.readUTF();
            this.args.push(_loc9_);
            _loc5_++;
         }
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc10_ = param1.readUTF();
            this.descriptions.push(_loc10_);
            _loc7_++;
         }
    }

}