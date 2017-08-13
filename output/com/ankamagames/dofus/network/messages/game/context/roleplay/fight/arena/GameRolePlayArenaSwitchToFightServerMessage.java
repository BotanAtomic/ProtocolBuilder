package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayArenaSwitchToFightServerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6575;
    private boolean _isInitialized = false;
    private String address = "";
    private int[] ports;
    private int[] ticket;
    private FuncTree _portstree;
    private FuncTree _tickettree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.address);
         param1.writeShort(this.ports.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ports.length)
         {
            if(this.ports[_loc2_] < 0 || this.ports[_loc2_] > 65535)
            {
               throw new Exception("Forbidden value (" + this.ports[_loc2_] + ") on element 2 (starting at 1) of ports.");
            }
            param1.writeShort(this.ports[_loc2_]);
            _loc2_++;
         }
         param1.writeVarInt(this.ticket.length);
         int _loc3_ = 0;
         while(_loc3_ < this.ticket.length)
         {
            param1.writeByte(this.ticket[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc6_ = 0;
         Object _loc7_ = 0;
         this.address = param1.readUTF();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedShort();
            if(_loc6_ < 0 || _loc6_ > 65535)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of ports.");
            }
            this.ports.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readVarInt();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readByte();
            this.ticket.push(_loc7_);
            _loc5_++;
         }
    }

}