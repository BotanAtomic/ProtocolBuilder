package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.dofus.network.messages.game.social.SocialNoticeSetRequestMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildMotdSetRequestMessage extends SocialNoticeSetRequestMessage implements INetworkMessage {

    private int protocolId = 6588;
    private boolean _isInitialized = false;
    private String content = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.content);
    }

    public void deserialize(ICustomDataInput param1) {
         this.content = param1.readUTF();
    }

}