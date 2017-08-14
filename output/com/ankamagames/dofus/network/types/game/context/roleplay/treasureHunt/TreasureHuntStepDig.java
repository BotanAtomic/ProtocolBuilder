package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntStepDig extends TreasureHuntStep implements INetworkType {

  public static final int protocolId = 465;

  @Override
  public void serialize(ICustomDataOutput param1) {}

  @Override
  public void deserialize(ICustomDataInput param1) {}
}
