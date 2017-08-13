package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.dofus.network.messages.game.social.SocialNoticeSetErrorMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildMotdSetErrorMessage extends SocialNoticeSetErrorMessage implements INetworkMessage {

    private int protocolId = 6591;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.reason);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SocialNoticeSetErrorMessage(param1);
    }

}