package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class NpcGenericActionRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5898;
    private boolean _isInitialized = false;
    private int npcId = 0;
    private int npcActionId = 0;
    private int npcMapId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.npcId);
         if(this.npcActionId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcActionId + ") on element npcActionId.");
         }
         param1.writeByte(this.npcActionId);
         param1.writeInt(this.npcMapId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.npcId = param1.readInt();
         this.npcActionId = param1.readByte();
         if(this.npcActionId < 0)
         {
            throw new Exception("Forbidden value (" + this.npcActionId + ") on element of NpcGenericActionRequestMessage.npcActionId.");
         }
         this.npcMapId = param1.readInt();
    }

}