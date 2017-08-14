package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildMember;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInformationsMemberUpdateMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public GuildMember member;
  private FuncTree _membertree;
  public static final int protocolId = 5597;

  public void serialize(ICustomDataOutput param1) {
    this.member.serializeAs_GuildMember(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.member = new GuildMember();
    this.member.deserialize(param1);
  }
}
