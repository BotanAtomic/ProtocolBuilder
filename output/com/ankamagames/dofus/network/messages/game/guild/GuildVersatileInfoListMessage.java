package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.GuildVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GuildVersatileInfoListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<GuildVersatileInformations> guilds;
  private FuncTree _guildstree;
  public static final int protocolId = 6435;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.guilds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.guilds.length) {
      param1.writeShort(((GuildVersatileInformations) (this.guilds[_loc2_])).getTypeId());
      ((GuildVersatileInformations) this.guilds[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    GuildVersatileInformations _loc5_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(GuildVersatileInformations, _loc4_);
      _loc5_.deserialize(param1);
      this.guilds.push(_loc5_);
      _loc3_++;
    }
  }
}
