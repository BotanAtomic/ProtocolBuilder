package com.ankamagames.dofus.network.messages.game.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicLatencyStatsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int latency = 0;
  public int sampleCount = 0;
  public int max = 0;
  public static final int protocolId = 5663;

  public void serialize(ICustomDataOutput param1) {
    if (this.latency < 0 || this.latency > 65535) {
      throw new Exception("Forbidden value (" + this.latency + ") on element latency.");
    }
    param1.writeShort(this.latency);
    if (this.sampleCount < 0) {
      throw new Exception("Forbidden value (" + this.sampleCount + ") on element sampleCount.");
    }
    param1.writeVarShort(this.sampleCount);
    if (this.max < 0) {
      throw new Exception("Forbidden value (" + this.max + ") on element max.");
    }
    param1.writeVarShort(this.max);
  }

  public void deserialize(ICustomDataInput param1) {
    this.latency = param1.readUnsignedShort();
    if (this.latency < 0 || this.latency > 65535) {
      throw new Exception(
          "Forbidden value (" + this.latency + ") on element of BasicLatencyStatsMessage.latency.");
    }

    this.sampleCount = param1.readVarUhShort();
    if (this.sampleCount < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.sampleCount
              + ") on element of BasicLatencyStatsMessage.sampleCount.");
    }

    this.max = param1.readVarUhShort();
    if (this.max < 0) {
      throw new Exception(
          "Forbidden value (" + this.max + ") on element of SkillActionDescriptionCollect.max.");
    }
  }
}
