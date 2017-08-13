package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceModificationNameAndTagValidMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6449;
    private boolean _isInitialized = false;
    private String allianceName = "";
    private String allianceTag = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.allianceName);
         param1.writeUTF(this.allianceTag);
    }

    public void deserialize(ICustomDataInput param1) {
         this.allianceName = param1.readUTF();
         this.allianceTag = param1.readUTF();
    }

}