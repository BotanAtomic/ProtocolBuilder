package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaSwitchToGameServerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6574;
    private boolean _isInitialized = false;
    private boolean validToken = false;
    private int[] ticket;
    private int homeServerId = 0;
    private FuncTree _tickettree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.validToken);
         param1.writeVarInt(this.ticket.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ticket.length)
         {
            param1.writeByte(this.ticket[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.homeServerId);
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = 0;
         this.validToken = param1.readBoolean();
         int _loc2_ = param1.readVarInt();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readByte();
            this.ticket.push(_loc4_);
            _loc3_++;
         }
         this.homeServerId = param1.readShort();
    }

}