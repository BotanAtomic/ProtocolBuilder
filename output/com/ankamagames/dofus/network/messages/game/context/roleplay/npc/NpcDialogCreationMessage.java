package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NpcDialogCreationMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5618;
    private boolean _isInitialized = false;
    private int mapId = 0;
    private int npcId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.mapId);
         param1.writeInt(this.npcId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         this.npcId = param1.readInt();
    }

}