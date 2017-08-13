package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.dofus.network.messages.game.social.BulletinMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildBulletinMessage extends BulletinMessage implements INetworkMessage {

    private int protocolId = 6689;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_BulletinMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         super.deserialize(param1);
    }

}