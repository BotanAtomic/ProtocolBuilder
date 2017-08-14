package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.version.Version;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationFailedForBadVersionMessage extends IdentificationFailedMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Version requiredVersion;
  private FuncTree _requiredVersiontree;
  public static final int protocolId = 21;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.reason);

    this.requiredVersion.serializeAs_Version(param1);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.requiredVersion = new Version();
    this.requiredVersion.deserialize(param1);
  }
}
