package com.ankamagames.dofus.network.messages.game.achievement;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementRewardRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6377;
    private boolean _isInitialized = false;
    private int achievementId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.achievementId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.achievementId = param1.readShort();
    }

}